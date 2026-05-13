/* * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 * Modified for Transaction Safety
 * Licensed under the Apache License, Version 2.0 */

// ... (Other imports remain the same)
import android.database.sqlite.SQLiteException;

public class NotesDatabaseHelper extends SQLiteOpenHelper {
    // ... (Existing code for CREATE statements and Triggers)

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        
        try {
            db.beginTransaction();
            
            boolean reCreateTriggers = false;
            boolean skipV2 = false;

            if (oldVersion == 1) {
                upgradeToV2(db);
                skipV2 = true;
                oldVersion++;
            }
            if (oldVersion == 2 && !skipV2) {
                upgradeToV3(db);
                reCreateTriggers = true;
                oldVersion++;
            }
            if (oldVersion == 3) {
                upgradeToV4(db);
                oldVersion++;
            }

            if (reCreateTriggers) {
                reCreateNoteTableTriggers(db);
                reCreateDataTableTriggers(db);
            }

            if (oldVersion != newVersion) {
                throw new SQLiteException("Upgrade failed. Expected version: " + newVersion + ", Current: " + oldVersion);
            }
            
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Upgrade failed: ", e);
            // Database will be recreated if this happens
            throw new RuntimeException("Database upgrade failed", e);
        } finally {
            db.endTransaction();
        }
    }

    // ... (Rest of the existing methods)
}
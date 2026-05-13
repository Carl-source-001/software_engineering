/* * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 * Modified for Memory Management
 * Licensed under the Apache License, Version 2.0 */

package net.micode.notes.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.telephony.PhoneNumberUtils;
import android.util.LruCache;
import android.util.Log;

public class Contact {
    // Use LruCache instead of HashMap to prevent OOM
    private static LruCache<String, String> sContactCache;
    private static final String TAG = "Contact";
    
    // Limit cache to 250 entries (approx. 1MB-2MB depending on name length)
    private static final int CACHE_SIZE = 250; 

    private static final String CALLER_ID_SELECTION = 
        "PHONE_NUMBERS_EQUAL(" + Phone.NUMBER + ",?) AND " + 
        Data.MIMETYPE + "='" + Phone.CONTENT_ITEM_TYPE + "'";

    static {
        sContactCache = new LruCache<>(CACHE_SIZE);
    }

    public static String getContact(Context context, String phoneNumber) {
        if (phoneNumber == null) return null;

        // Check cache first
        String name = sContactCache.get(phoneNumber);
        if (name != null) {
            return name;
        }

        // Sanitize phone number
        String minMatch = PhoneNumberUtils.toCallerIDMinMatch(phoneNumber);
        if (minMatch == null) return null;

        String selection = CALLER_ID_SELECTION.replace("+", minMatch);
        Cursor cursor = null;
        
        try {
            cursor = context.getContentResolver().query(
                Data.CONTENT_URI,
                new String[]{Phone.DISPLAY_NAME},
                selection,
                new String[]{phoneNumber},
                null
            );

            if (cursor != null && cursor.moveToFirst()) {
                name = cursor.getString(0);
                sContactCache.put(phoneNumber, name); // Put in cache
                return name;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error querying contact: ", e);
        } finally {
            if (cursor != null) {
                cursor.close(); // Ensure cursor is closed
            }
        }
        
        Log.d(TAG, "No contact matched with number:" + phoneNumber);
        return null;
    }
}
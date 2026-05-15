/*
 * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.micode.notes.gtask.data;

import android.database.Cursor;
import android.util.Log;

import net.micode.notes.tool.GTaskStringUtils;

import org.json.JSONException;
import org.json.JSONObject;

// 元数据
public class MetaData extends Task {   // MetaData 类继承 Task 类

    // MetaData.class 获取 MetaData 类的 “反射入口”（Class 对象）
    // 通过这个入口就能用反射拿到类的所有信息
    // getSimpleName() 函数就是拿到类的简单名字
    private final static String TAG = MetaData.class.getSimpleName();

    private String mRelatedGid = null;

    // JSONObject 是 Java 程序中对 JSON 文本的对象化表示
    // 把 JSON 字符串解析成 Java 对象，方便代码操作增删改查键值对

    public void setMeta(String gid, JSONObject metaInfo) {
        try {

            // 向 metaInfo 中加入键值对 ("meta_gid",gid)

            metaInfo.put(GTaskStringUtils.META_HEAD_GTASK_ID, gid);
        } catch (JSONException e) {
            Log.e(TAG, "failed to put related gid");
        }

        // 将 mNode 设置成 metaInfo，见 Task 类

        setNotes(metaInfo.toString());

        // 设置 Name ，见 Node 类

        setName(GTaskStringUtils.META_NOTE_NAME);
    }

    public String getRelatedGid() {
        return mRelatedGid;
    }

    // @Override 是 Java 的注解，告诉编译器 “这个方法是重写自父类 / 接口的方法”
    // getNotes() 方法返回 mNode

    @Override
    public boolean isWorthSaving() {
        return getNotes() != null;
    }

    @Override
    public void setContentByRemoteJSON(JSONObject js) {

        // super 是 Java 中专门用于访问父类成员的关键字
        // setContentByRemoteJSON(js) 函数根据 js 配置了一些 Node 与 Task 里的数据

        super.setContentByRemoteJSON(js);
        if (getNotes() != null) {
            try {
                JSONObject metaInfo = new JSONObject(getNotes().trim());

                // get meta_gid

                mRelatedGid = metaInfo.getString(GTaskStringUtils.META_HEAD_GTASK_ID);
            } catch (JSONException e) {
                Log.w(TAG, "failed to get related gid");
                mRelatedGid = null;
            }
        }
    }

    @Override
    public void setContentByLocalJSON(JSONObject js) {
        // this function should not be called
        throw new IllegalAccessError("MetaData:setContentByLocalJSON should not be called");
    }

    @Override
    public JSONObject getLocalJSONFromContent() {
        throw new IllegalAccessError("MetaData:getLocalJSONFromContent should not be called");
    }

    @Override
    public int getSyncAction(Cursor c) {
        throw new IllegalAccessError("MetaData:getSyncAction should not be called");
    }

}

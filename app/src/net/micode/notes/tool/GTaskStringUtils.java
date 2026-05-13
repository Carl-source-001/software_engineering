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

package net.micode.notes.tool;

/**
 * Google Tasks同步工具类，定义了Google Tasks API相关的常量
 */
public class GTaskStringUtils {

    /**
     * Action ID字段
     */
    public final static String GTASK_JSON_ACTION_ID = "action_id";

    /**
     * Action列表字段
     */
    public final static String GTASK_JSON_ACTION_LIST = "action_list";

    /**
     * Action类型字段
     */
    public final static String GTASK_JSON_ACTION_TYPE = "action_type";

    /**
     * Action类型：创建
     */
    public final static String GTASK_JSON_ACTION_TYPE_CREATE = "create";

    /**
     * Action类型：获取所有
     */
    public final static String GTASK_JSON_ACTION_TYPE_GETALL = "get_all";

    /**
     * Action类型：移动
     */
    public final static String GTASK_JSON_ACTION_TYPE_MOVE = "move";

    /**
     * Action类型：更新
     */
    public final static String GTASK_JSON_ACTION_TYPE_UPDATE = "update";

    /**
     * 创建者ID字段
     */
    public final static String GTASK_JSON_CREATOR_ID = "creator_id";

    /**
     * 子实体字段
     */
    public final static String GTASK_JSON_CHILD_ENTITY = "child_entity";

    /**
     * 客户端版本字段
     */
    public final static String GTASK_JSON_CLIENT_VERSION = "client_version";

    /**
     * 完成状态字段
     */
    public final static String GTASK_JSON_COMPLETED = "completed";

    /**
     * 当前列表ID字段
     */
    public final static String GTASK_JSON_CURRENT_LIST_ID = "current_list_id";

    /**
     * 默认列表ID字段
     */
    public final static String GTASK_JSON_DEFAULT_LIST_ID = "default_list_id";

    /**
     * 删除状态字段
     */
    public final static String GTASK_JSON_DELETED = "deleted";

    /**
     * 目标列表字段
     */
    public final static String GTASK_JSON_DEST_LIST = "dest_list";

    /**
     * 目标父实体字段
     */
    public final static String GTASK_JSON_DEST_PARENT = "dest_parent";

    /**
     * 目标父实体类型字段
     */
    public final static String GTASK_JSON_DEST_PARENT_TYPE = "dest_parent_type";

    /**
     * 实体增量字段
     */
    public final static String GTASK_JSON_ENTITY_DELTA = "entity_delta";

    /**
     * 实体类型字段
     */
    public final static String GTASK_JSON_ENTITY_TYPE = "entity_type";

    /**
     * 获取已删除字段
     */
    public final static String GTASK_JSON_GET_DELETED = "get_deleted";

    /**
     * ID字段
     */
    public final static String GTASK_JSON_ID = "id";

    /**
     * 索引字段
     */
    public final static String GTASK_JSON_INDEX = "index";

    /**
     * 最后修改时间字段
     */
    public final static String GTASK_JSON_LAST_MODIFIED = "last_modified";

    /**
     * 最新同步点字段
     */
    public final static String GTASK_JSON_LATEST_SYNC_POINT = "latest_sync_point";

    /**
     * 列表ID字段
     */
    public final static String GTASK_JSON_LIST_ID = "list_id";

    /**
     * 列表字段
     */
    public final static String GTASK_JSON_LISTS = "lists";

    /**
     * 名称字段
     */
    public final static String GTASK_JSON_NAME = "name";

    /**
     * 新ID字段
     */
    public final static String GTASK_JSON_NEW_ID = "new_id";

    /**
     * 备注字段
     */
    public final static String GTASK_JSON_NOTES = "notes";

    /**
     * 父ID字段
     */
    public final static String GTASK_JSON_PARENT_ID = "parent_id";

    /**
     * 前一个兄弟ID字段
     */
    public final static String GTASK_JSON_PRIOR_SIBLING_ID = "prior_sibling_id";

    /**
     * 结果字段
     */
    public final static String GTASK_JSON_RESULTS = "results";

    /**
     * 源列表字段
     */
    public final static String GTASK_JSON_SOURCE_LIST = "source_list";

    /**
     * 任务字段
     */
    public final static String GTASK_JSON_TASKS = "tasks";

    /**
     * 类型字段
     */
    public final static String GTASK_JSON_TYPE = "type";

    /**
     * 类型：组
     */
    public final static String GTASK_JSON_TYPE_GROUP = "GROUP";

    /**
     * 类型：任务
     */
    public final static String GTASK_JSON_TYPE_TASK = "TASK";

    /**
     * 用户字段
     */
    public final static String GTASK_JSON_USER = "user";

    /**
     * MIUI文件夹前缀
     */
    public final static String MIUI_FOLDER_PREFFIX = "[MIUI_Notes]";

    /**
     * 默认文件夹名称
     */
    public final static String FOLDER_DEFAULT = "Default";

    /**
     * 通话记录文件夹名称
     */
    public final static String FOLDER_CALL_NOTE = "Call_Note";

    /**
     * 元数据文件夹名称
     */
    public final static String FOLDER_META = "METADATA";

    /**
     * 元数据头部：Google Task ID
     */
    public final static String META_HEAD_GTASK_ID = "meta_gid";

    /**
     * 元数据头部：备注
     */
    public final static String META_HEAD_NOTE = "meta_note";

    /**
     * 元数据头部：数据
     */
    public final static String META_HEAD_DATA = "meta_data";

    /**
     * 元数据备注名称
     */
    public final static String META_NOTE_NAME = "[META INFO] DON'T UPDATE AND DELETE";

}

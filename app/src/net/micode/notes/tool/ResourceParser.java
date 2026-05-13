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

import android.content.Context;
import android.preference.PreferenceManager;

import net.micode.notes.R;
import net.micode.notes.ui.NotesPreferenceActivity;

/**
 * 资源解析工具类，用于管理便签的颜色、字体大小等资源
 */
public class ResourceParser {

    /**
     * 黄色背景索引
     */
    public static final int YELLOW           = 0;
    /**
     * 蓝色背景索引
     */
    public static final int BLUE             = 1;
    /**
     * 白色背景索引
     */
    public static final int WHITE            = 2;
    /**
     * 绿色背景索引
     */
    public static final int GREEN            = 3;
    /**
     * 红色背景索引
     */
    public static final int RED              = 4;

    /**
     * 默认背景颜色索引
     */
    public static final int BG_DEFAULT_COLOR = YELLOW;

    /**
     * 小字体索引
     */
    public static final int TEXT_SMALL       = 0;
    /**
     * 中等字体索引
     */
    public static final int TEXT_MEDIUM      = 1;
    /**
     * 大字体索引
     */
    public static final int TEXT_LARGE       = 2;
    /**
     * 超大字体索引
     */
    public static final int TEXT_SUPER       = 3;

    /**
     * 默认字体大小索引
     */
    public static final int BG_DEFAULT_FONT_SIZE = TEXT_MEDIUM;

    /**
     * 便签背景资源内部类，管理便签编辑界面的背景资源
     */
    public static class NoteBgResources {
        /**
         * 便签编辑背景资源数组
         */
        private final static int [] BG_EDIT_RESOURCES = new int [] {
            R.drawable.edit_yellow,
            R.drawable.edit_blue,
            R.drawable.edit_white,
            R.drawable.edit_green,
            R.drawable.edit_red
        };

        /**
         * 便签标题背景资源数组
         */
        private final static int [] BG_EDIT_TITLE_RESOURCES = new int [] {
            R.drawable.edit_title_yellow,
            R.drawable.edit_title_blue,
            R.drawable.edit_title_white,
            R.drawable.edit_title_green,
            R.drawable.edit_title_red
        };

        /**
         * 获取便签背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getNoteBgResource(int id) {
            // 根据索引返回对应的背景资源ID
            return BG_RESOURCES[id];
        }

        /**
         * 获取便签标题背景资源
         * 
         * @param id 背景颜色索引
         * @return 标题背景资源ID
         */
        public static int getNoteBgTitleResource(int id) {
            // 根据索引返回对应的标题背景资源ID
            return BG_TITLE_RESOURCES[id];
        }
    }

    /**
     * 获取默认背景ID
     * 
     * @param context 上下文对象
     * @return 默认背景ID
     */
    public static int getDefaultBgId(Context context) {
        // 检查用户是否设置了随机背景颜色
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(
                NotesPreferenceActivity.PREFERENCE_SET_BG_COLOR_KEY, false)) {
            // 如果启用了随机背景，返回随机索引的背景ID
            return (int) (Math.random() * NoteBgResources.BG_EDIT_RESOURCES.length);
        } else {
            // 如果未启用随机背景，返回默认背景颜色
            return BG_DEFAULT_COLOR;
        }
    }

    /**
     * 便签列表项背景资源内部类，管理便签列表项的背景资源
     */
    public static class NoteItemBgResources {
        /**
         * 列表项首项背景资源数组
         */
        private final static int [] BG_FIRST_RESOURCES = new int [] {
            R.drawable.list_yellow_up,
            R.drawable.list_blue_up,
            R.drawable.list_white_up,
            R.drawable.list_green_up,
            R.drawable.list_red_up
        };

        /**
         * 列表项中间项背景资源数组
         */
        private final static int [] BG_NORMAL_RESOURCES = new int [] {
            R.drawable.list_yellow_middle,
            R.drawable.list_blue_middle,
            R.drawable.list_white_middle,
            R.drawable.list_green_middle,
            R.drawable.list_red_middle
        };

        /**
         * 列表项末项背景资源数组
         */
        private final static int [] BG_LAST_RESOURCES = new int [] {
            R.drawable.list_yellow_down,
            R.drawable.list_blue_down,
            R.drawable.list_white_down,
            R.drawable.list_green_down,
            R.drawable.list_red_down,
        };

        /**
         * 列表项单项背景资源数组
         */
        private final static int [] BG_SINGLE_RESOURCES = new int [] {
            R.drawable.list_yellow_single,
            R.drawable.list_blue_single,
            R.drawable.list_white_single,
            R.drawable.list_green_single,
            R.drawable.list_red_single
        };

        /**
         * 获取列表项首项背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getNoteBgFirstRes(int id) {
            // 根据索引返回列表项首项背景资源ID
            return BG_FIRST_RESOURCES[id];
        }

        /**
         * 获取列表项末项背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getNoteBgLastRes(int id) {
            // 根据索引返回列表项末项背景资源ID
            return BG_LAST_RESOURCES[id];
        }

        /**
         * 获取列表项单项背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getNoteBgSingleRes(int id) {
            // 根据索引返回列表项单项背景资源ID
            return BG_SINGLE_RESOURCES[id];
        }

        /**
         * 获取列表项中间项背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getNoteBgNormalRes(int id) {
            // 根据索引返回列表项中间项背景资源ID
            return BG_NORMAL_RESOURCES[id];
        }

        /**
         * 获取文件夹背景资源
         * 
         * @return 文件夹背景资源ID
         */
        public static int getFolderBgRes() {
            // 返回文件夹背景资源ID
            return R.drawable.list_folder;
        }
    }

    /**
     * 小部件背景资源内部类，管理便签小部件的背景资源
     */
    public static class WidgetBgResources {
        /**
         * 2x2小部件背景资源数组
         */
        private final static int [] BG_2X_RESOURCES = new int [] {
            R.drawable.widget_2x_yellow,
            R.drawable.widget_2x_blue,
            R.drawable.widget_2x_white,
            R.drawable.widget_2x_green,
            R.drawable.widget_2x_red,
        };

        /**
         * 获取2x2小部件背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getWidget2xBgResource(int id) {
            return BG_2X_RESOURCES[id];
        }

        /**
         * 4x4小部件背景资源数组
         */
        private final static int [] BG_4X_RESOURCES = new int [] {
            R.drawable.widget_4x_yellow,
            R.drawable.widget_4x_blue,
            R.drawable.widget_4x_white,
            R.drawable.widget_4x_green,
            R.drawable.widget_4x_red
        };

        /**
         * 获取4x4小部件背景资源
         * 
         * @param id 背景颜色索引
         * @return 背景资源ID
         */
        public static int getWidget4xBgResource(int id) {
            return BG_4X_RESOURCES[id];
        }
    }

    /**
     * 文本外观资源内部类，管理便签文本的样式资源
     */
    public static class TextAppearanceResources {
        /**
         * 文本外观资源数组
         */
        private final static int [] TEXTAPPEARANCE_RESOURCES = new int [] {
            R.style.TextAppearanceNormal,
            R.style.TextAppearanceMedium,
            R.style.TextAppearanceLarge,
            R.style.TextAppearanceSuper
        };

        /**
         * 获取文本外观资源
         * 
         * @param id 文本大小索引
         * @return 文本外观资源ID
         */
        public static int getTexAppearanceResource(int id) {
            /**
             * HACKME: Fix bug of store the resource id in shared preference.
             * The id may larger than the length of resources, in this case,
             * return the {@link ResourceParser#BG_DEFAULT_FONT_SIZE}
             */
            // 检查索引是否超出资源数组范围
            if (id >= TEXTAPPEARANCE_RESOURCES.length) {
                // 如果超出范围，返回默认字体大小
                return BG_DEFAULT_FONT_SIZE;
            }
            // 返回对应的文本外观资源ID
            return TEXTAPPEARANCE_RESOURCES[id];
        }

        /**
         * 获取资源数量
         * 
         * @return 资源数量
         */
        public static int getResourcesSize() {
            // 返回文本外观资源数组的长度
            return TEXTAPPEARANCE_RESOURCES.length;
        }
    }
}

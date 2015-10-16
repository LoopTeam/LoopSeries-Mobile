package com.loop_anime.android.utils;

import android.content.Context;

import com.loop_anime.android.model.db.DBHelper;
import com.loop_anime.android.model.db.TypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

/**
 * User: Yilun Chen
 * Date: 15/10/16
 */
public class StorIOUtils {

    public static StorIOSQLite getStorIOLite(Context context, TypeMapping.MAPPING... mappings) {
        DefaultStorIOSQLite.CompleteBuilder builder
                = DefaultStorIOSQLite.builder().sqliteOpenHelper(DBHelper.instance(context));
        for (TypeMapping.MAPPING mapping : mappings) {
            //noinspection unchecked
            builder.addTypeMapping(mapping.getClassLiteral(), mapping.getTypeMapping());
        }
        return builder.build();
    }
}

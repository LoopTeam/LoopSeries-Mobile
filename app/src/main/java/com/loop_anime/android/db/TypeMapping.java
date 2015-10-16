package com.loop_anime.android.db;

import com.loop_anime.android.model.Anime;
import com.loop_anime.android.model.AnimeStorIOSQLiteDeleteResolver;
import com.loop_anime.android.model.AnimeStorIOSQLiteGetResolver;
import com.loop_anime.android.model.AnimeStorIOSQLitePutResolver;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;

/**
 * User: Yilun Chen
 * Date: 15/10/16
 */
public class TypeMapping {

    public enum MAPPING {

        ANIME(Anime.class, ANIME_TYPE_MAPPING),;

        private SQLiteTypeMapping<?> mTypeMapping;

        private Class mClassLiteral;

        MAPPING(Class<?> classLiteral, SQLiteTypeMapping<?> typeMapping) {
            mClassLiteral = classLiteral;
            mTypeMapping = typeMapping;
        }

        public SQLiteTypeMapping<?> getTypeMapping() {
            return mTypeMapping;
        }

        public Class getClassLiteral() {
            return mClassLiteral;
        }

    }

    private final static SQLiteTypeMapping<Anime> ANIME_TYPE_MAPPING = SQLiteTypeMapping.<Anime>builder()
            .putResolver(new AnimeStorIOSQLitePutResolver())
            .getResolver(new AnimeStorIOSQLiteGetResolver())
            .deleteResolver(new AnimeStorIOSQLiteDeleteResolver()).build();

}

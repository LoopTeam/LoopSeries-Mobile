package com.loop_anime.android.model.db;

import android.test.AndroidTestCase;
import android.util.Log;

import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.model.dao.AnimeStorIOSQLiteDeleteResolver;
import com.loop_anime.android.model.dao.AnimeStorIOSQLiteGetResolver;
import com.loop_anime.android.model.dao.AnimeStorIOSQLitePutResolver;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.DeleteQuery;
import com.pushtorefresh.storio.sqlite.queries.Query;

import junit.framework.Assert;

/**
 * User: Yilun Chen
 * Date: 15/10/14
 */
public class DBTableTest extends AndroidTestCase {

    public void TestAnimeTable() throws Exception {
        StorIOSQLite storIOSQLite = DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(DBHelper.instance(getContext()))
                .addTypeMapping(Anime.class,
                        SQLiteTypeMapping.<Anime>builder()
                                .putResolver(new AnimeStorIOSQLitePutResolver())
                                .getResolver(new AnimeStorIOSQLiteGetResolver())
                                .deleteResolver(new AnimeStorIOSQLiteDeleteResolver())
                                .build())
                .build();
        storIOSQLite
                .delete()
                .byQuery(DeleteQuery.builder()
                                .table(Table.Anime.TABLE_NAME)
                                .build()
                ).prepare()
                .executeAsBlocking();

        Anime anime = new Anime();
        anime.setId(1);
        final String title = "Detective Conan";
        anime.setTitle(title);
        storIOSQLite.put()
                .object(anime)
                .prepare()
                .executeAsBlocking();

        Anime result = storIOSQLite.get()
                .listOfObjects(Anime.class)
                .withQuery(Query.builder()
                        .table(Table.Anime.TABLE_NAME)
                        .where(Table.Anime.ID + "= ?")
                        .whereArgs(1)
                        .build())
                .prepare()
                .executeAsBlocking()
                .get(0);
        Log.v("TITLE", result.getTitle());
        Assert.assertEquals(title, result.getTitle());
    }

}
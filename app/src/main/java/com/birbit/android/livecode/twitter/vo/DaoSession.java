package com.birbit.android.livecode.twitter.vo;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.IdentityScopeType;

import com.birbit.android.livecode.twitter.vo.Tweet;
import com.birbit.android.livecode.twitter.vo.User;

import com.birbit.android.livecode.twitter.vo.TweetDao;
import com.birbit.android.livecode.twitter.vo.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig tweetDaoConfig;
    private final DaoConfig userDaoConfig;

    private final TweetDao tweetDao;
    private final UserDao userDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        tweetDaoConfig = daoConfigMap.get(TweetDao.class).clone();
        tweetDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        tweetDao = new TweetDao(tweetDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Tweet.class, tweetDao);
        registerDao(User.class, userDao);
    }

    public void clear() {
        tweetDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
    }

    public void deleteAllData() {
        tweetDao.deleteAll();
        userDao.deleteAll();
    }


    public TweetDao getTweetDao() {
        return tweetDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}

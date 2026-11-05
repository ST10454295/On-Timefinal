package com.ontime.app.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ActivityDao _activityDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `activities` (`localId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `remoteId` TEXT, `uid` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `type` TEXT NOT NULL, `date` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `importance` TEXT NOT NULL, `syncState` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f4e25de5d1c1fbd34359ccf08791bc85')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `activities`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsActivities = new HashMap<String, TableInfo.Column>(11);
        _columnsActivities.put("localId", new TableInfo.Column("localId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("remoteId", new TableInfo.Column("remoteId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("uid", new TableInfo.Column("uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("importance", new TableInfo.Column("importance", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysActivities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesActivities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoActivities = new TableInfo("activities", _columnsActivities, _foreignKeysActivities, _indicesActivities);
        final TableInfo _existingActivities = TableInfo.read(db, "activities");
        if (!_infoActivities.equals(_existingActivities)) {
          return new RoomOpenHelper.ValidationResult(false, "activities(com.ontime.app.data.ActivityEntity).\n"
                  + " Expected:\n" + _infoActivities + "\n"
                  + " Found:\n" + _existingActivities);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f4e25de5d1c1fbd34359ccf08791bc85", "95695d942aed69018e0b1e45eda85601");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "activities");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `activities`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ActivityDao.class, ActivityDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ActivityDao activityDao() {
    if (_activityDao != null) {
      return _activityDao;
    } else {
      synchronized(this) {
        if(_activityDao == null) {
          _activityDao = new ActivityDao_Impl(this);
        }
        return _activityDao;
      }
    }
  }
}

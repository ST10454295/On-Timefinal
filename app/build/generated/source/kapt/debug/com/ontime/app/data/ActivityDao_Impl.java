package com.ontime.app.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ActivityDao_Impl implements ActivityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ActivityEntity> __insertionAdapterOfActivityEntity;

  private final SharedSQLiteStatement __preparedStmtOfMarkSynced;

  public ActivityDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfActivityEntity = new EntityInsertionAdapter<ActivityEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `activities` (`localId`,`remoteId`,`uid`,`title`,`description`,`type`,`date`,`startTime`,`endTime`,`importance`,`syncState`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ActivityEntity entity) {
        statement.bindLong(1, entity.getLocalId());
        if (entity.getRemoteId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getRemoteId());
        }
        if (entity.getUid() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUid());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        if (entity.getType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getType());
        }
        if (entity.getDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDate());
        }
        if (entity.getStartTime() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getStartTime());
        }
        if (entity.getEndTime() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getEndTime());
        }
        if (entity.getImportance() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getImportance());
        }
        if (entity.getSyncState() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSyncState());
        }
      }
    };
    this.__preparedStmtOfMarkSynced = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE activities SET remoteId = ?, syncState = 'SYNCED' WHERE localId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final ActivityEntity entity, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfActivityEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markSynced(final long localId, final String remoteId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkSynced.acquire();
        int _argIndex = 1;
        if (remoteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, remoteId);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, localId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfMarkSynced.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final String uid,
      final Continuation<? super List<ActivityEntity>> $completion) {
    final String _sql = "SELECT * FROM activities WHERE uid = ? ORDER BY date, startTime";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ActivityEntity>>() {
      @Override
      @NonNull
      public List<ActivityEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocalId = CursorUtil.getColumnIndexOrThrow(_cursor, "localId");
          final int _cursorIndexOfRemoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteId");
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfImportance = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final List<ActivityEntity> _result = new ArrayList<ActivityEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ActivityEntity _item;
            final long _tmpLocalId;
            _tmpLocalId = _cursor.getLong(_cursorIndexOfLocalId);
            final String _tmpRemoteId;
            if (_cursor.isNull(_cursorIndexOfRemoteId)) {
              _tmpRemoteId = null;
            } else {
              _tmpRemoteId = _cursor.getString(_cursorIndexOfRemoteId);
            }
            final String _tmpUid;
            if (_cursor.isNull(_cursorIndexOfUid)) {
              _tmpUid = null;
            } else {
              _tmpUid = _cursor.getString(_cursorIndexOfUid);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpStartTime;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmpStartTime = null;
            } else {
              _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            }
            final String _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
            }
            final String _tmpImportance;
            if (_cursor.isNull(_cursorIndexOfImportance)) {
              _tmpImportance = null;
            } else {
              _tmpImportance = _cursor.getString(_cursorIndexOfImportance);
            }
            final String _tmpSyncState;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmpSyncState = null;
            } else {
              _tmpSyncState = _cursor.getString(_cursorIndexOfSyncState);
            }
            _item = new ActivityEntity(_tmpLocalId,_tmpRemoteId,_tmpUid,_tmpTitle,_tmpDescription,_tmpType,_tmpDate,_tmpStartTime,_tmpEndTime,_tmpImportance,_tmpSyncState);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getForDate(final String uid, final String date,
      final Continuation<? super List<ActivityEntity>> $completion) {
    final String _sql = "SELECT * FROM activities WHERE uid = ? AND date = ? ORDER BY startTime";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ActivityEntity>>() {
      @Override
      @NonNull
      public List<ActivityEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocalId = CursorUtil.getColumnIndexOrThrow(_cursor, "localId");
          final int _cursorIndexOfRemoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteId");
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfImportance = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final List<ActivityEntity> _result = new ArrayList<ActivityEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ActivityEntity _item;
            final long _tmpLocalId;
            _tmpLocalId = _cursor.getLong(_cursorIndexOfLocalId);
            final String _tmpRemoteId;
            if (_cursor.isNull(_cursorIndexOfRemoteId)) {
              _tmpRemoteId = null;
            } else {
              _tmpRemoteId = _cursor.getString(_cursorIndexOfRemoteId);
            }
            final String _tmpUid;
            if (_cursor.isNull(_cursorIndexOfUid)) {
              _tmpUid = null;
            } else {
              _tmpUid = _cursor.getString(_cursorIndexOfUid);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpStartTime;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmpStartTime = null;
            } else {
              _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            }
            final String _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
            }
            final String _tmpImportance;
            if (_cursor.isNull(_cursorIndexOfImportance)) {
              _tmpImportance = null;
            } else {
              _tmpImportance = _cursor.getString(_cursorIndexOfImportance);
            }
            final String _tmpSyncState;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmpSyncState = null;
            } else {
              _tmpSyncState = _cursor.getString(_cursorIndexOfSyncState);
            }
            _item = new ActivityEntity(_tmpLocalId,_tmpRemoteId,_tmpUid,_tmpTitle,_tmpDescription,_tmpType,_tmpDate,_tmpStartTime,_tmpEndTime,_tmpImportance,_tmpSyncState);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getPending(final String uid,
      final Continuation<? super List<ActivityEntity>> $completion) {
    final String _sql = "SELECT * FROM activities WHERE uid = ? AND syncState = 'PENDING'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ActivityEntity>>() {
      @Override
      @NonNull
      public List<ActivityEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocalId = CursorUtil.getColumnIndexOrThrow(_cursor, "localId");
          final int _cursorIndexOfRemoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteId");
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfImportance = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final List<ActivityEntity> _result = new ArrayList<ActivityEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ActivityEntity _item;
            final long _tmpLocalId;
            _tmpLocalId = _cursor.getLong(_cursorIndexOfLocalId);
            final String _tmpRemoteId;
            if (_cursor.isNull(_cursorIndexOfRemoteId)) {
              _tmpRemoteId = null;
            } else {
              _tmpRemoteId = _cursor.getString(_cursorIndexOfRemoteId);
            }
            final String _tmpUid;
            if (_cursor.isNull(_cursorIndexOfUid)) {
              _tmpUid = null;
            } else {
              _tmpUid = _cursor.getString(_cursorIndexOfUid);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpStartTime;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmpStartTime = null;
            } else {
              _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            }
            final String _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
            }
            final String _tmpImportance;
            if (_cursor.isNull(_cursorIndexOfImportance)) {
              _tmpImportance = null;
            } else {
              _tmpImportance = _cursor.getString(_cursorIndexOfImportance);
            }
            final String _tmpSyncState;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmpSyncState = null;
            } else {
              _tmpSyncState = _cursor.getString(_cursorIndexOfSyncState);
            }
            _item = new ActivityEntity(_tmpLocalId,_tmpRemoteId,_tmpUid,_tmpTitle,_tmpDescription,_tmpType,_tmpDate,_tmpStartTime,_tmpEndTime,_tmpImportance,_tmpSyncState);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object countPending(final String uid, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM activities WHERE uid = ? AND syncState = 'PENDING'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object countByRemoteId(final String uid, final String remoteId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM activities WHERE uid = ? AND remoteId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    _argIndex = 2;
    if (remoteId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, remoteId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

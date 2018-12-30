package hva.semen.seyfullah.com.hva_challenge_week_7.Repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import hva.semen.seyfullah.com.hva_challenge_week_7.Dao.BucketDao;
import hva.semen.seyfullah.com.hva_challenge_week_7.Database.AppDatabase;
import hva.semen.seyfullah.com.hva_challenge_week_7.Model.Bucket;

public class BucketRepository {

    private AppDatabase mAppDatabase;
    private BucketDao mBucketDao;

    private LiveData<List<Bucket>> mBuckets;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public BucketRepository(Context context) {
        mAppDatabase = AppDatabase.getInstance(context);
        mBucketDao = mAppDatabase.bucketDao();
        mBuckets = mBucketDao.getAllBuckets();
    }

    public LiveData<List<Bucket>> getAllBuckets() {
        return mBuckets;
    }

    public void insert(final Bucket bucket) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.insertBuckets(bucket);
            }
        });
    }

    public void update(final Bucket bucket) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.updateBuckets(bucket);
            }
        });
    }

    public void delete(final Bucket bucket) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.deleteBuckets(bucket);
            }
        });
    }
}

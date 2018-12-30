package hva.semen.seyfullah.com.hva_challenge_week_7.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import hva.semen.seyfullah.com.hva_challenge_week_7.Model.Bucket;

@Dao
public interface BucketDao {

    @Query("SELECT * FROM bucket")
    public LiveData<List<Bucket>> getAllBuckets();

    @Insert
    public void insertBuckets(Bucket buckets);

    @Delete
    public void deleteBuckets(Bucket buckets);

    @Update
    public void updateBuckets(Bucket buckets);
}

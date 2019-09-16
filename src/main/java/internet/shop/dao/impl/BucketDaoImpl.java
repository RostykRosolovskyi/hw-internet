package internet.shop.dao.impl;

import internet.shop.dao.BucketDao;
import internet.shop.dao.Storage;
import internet.shop.lib.Dao;
import internet.shop.model.Bucket;

import java.util.NoSuchElementException;

@Dao
public class BucketDaoImpl implements BucketDao {

    @Override
    public Bucket add(Bucket bucket) {
        Storage.buckets.add(bucket);
        return bucket;
    }

    @Override
    public Bucket get(Long id) {
        return Storage.buckets.stream()
                .filter(bucket -> bucket.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find bucket with id " + id));
    }

    @Override
    public Bucket update(Bucket newBucket) {
        Bucket bucket = get(newBucket.getId());
        bucket.setItems(newBucket.getItems());
        bucket.setUserId(newBucket.getUserId());
        return bucket;
    }

    @Override
    public void delete(Long id) {
        Storage.buckets
                .removeIf(bucket -> bucket.getId().equals(id));
    }
}

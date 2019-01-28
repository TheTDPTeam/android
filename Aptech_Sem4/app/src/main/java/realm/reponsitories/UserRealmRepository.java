package realm.reponsitories;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import models.outputs.UserDetail;


public class UserRealmRepository{
    private static UserRealmRepository userRealmRepository;
    private UserRealmRepository(){
    }

    public static UserRealmRepository getInstance(){
        if(userRealmRepository == null){
            userRealmRepository = new UserRealmRepository();
        }
        return userRealmRepository;
    }

    public void saveAsync(final UserDetail user) {
        final Realm insertRealm = Realm.getDefaultInstance();
        insertRealm.beginTransaction();
        insertRealm.insertOrUpdate(user);
        insertRealm.commitTransaction();
        insertRealm.close();
//
//        insertRealm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm backgroundRealm) {
//                backgroundRealm.insertOrUpdate(user);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                insertRealm.close();
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                insertRealm.close();
//            }
//        });
    }

    public void updateAsync(final UserDetail author) {
        final Realm updateRealm = Realm.getDefaultInstance();
        updateRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm backgroundRealm) {
                UserDetail user = backgroundRealm.where(UserDetail.class).equalTo("id",author.getId()).findFirst();
                user = author;
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                updateRealm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                updateRealm.close();
            }
        });

    }

    public List<UserDetail> getAllUserDetails(Realm passedInRealm) {
        RealmResults<UserDetail> users = passedInRealm.where(UserDetail.class).findAll();
        return users;
    }

    public UserDetail getUserDetailById(long id) {
        Realm realm = Realm.getDefaultInstance();
        UserDetail inMemoryUser = null;
        try {
            UserDetail user = realm.where(UserDetail.class).equalTo("id", id).findFirst();
            inMemoryUser = realm.copyFromRealm(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        realm.close();
        return inMemoryUser;
    }

    public void deleteAsync(final long id) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm backgroundRealm) {
                RealmResults<UserDetail> clients = backgroundRealm.where(UserDetail.class).findAll();
                UserDetail clientToBeDeleted = clients.where().equalTo("id", id).findFirst();
                clientToBeDeleted.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();
            }
        });
    }
}

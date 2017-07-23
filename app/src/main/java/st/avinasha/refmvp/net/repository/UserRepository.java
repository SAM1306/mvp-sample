package st.avinasha.refmvp.net.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import st.avinasha.refmvp.net.api.UserApiService;
import st.avinasha.refmvp.net.model.user.User;

@Singleton
public class UserRepository {

    private final UserApiService userApiService;
    private List<User> mUserListCache = new ArrayList<>();

    @Inject
    UserRepository(@NonNull Retrofit retrofit) {
        userApiService = retrofit.create(UserApiService.class);
    }

    public Observable<List<User>> getUsers() {
        if (mUserListCache == null || mUserListCache.isEmpty()) {
            return userApiService.getUsers().doOnNext(new Consumer<List<User>>() {
                @Override
                public void accept(List<User> users) throws Exception {
                    mUserListCache.clear();
                    mUserListCache.addAll(users);
                }
            });
        }
        return Observable.just(mUserListCache);
    }

    public Observable<User> getUserById(int id) {
        return userApiService.getUserById(id);
    }
}

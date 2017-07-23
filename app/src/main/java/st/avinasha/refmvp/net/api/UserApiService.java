package st.avinasha.refmvp.net.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import st.avinasha.refmvp.net.model.user.User;

public interface UserApiService {

    @GET("/users") Observable<List<User>> getUsers();

    @GET("/users") Observable<User> getUserById(@Query("id") int id);
}

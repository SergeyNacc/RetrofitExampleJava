package nacc.sergey.retrofitexamplejava.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import nacc.sergey.retrofitexamplejava.data.Api;
import nacc.sergey.retrofitexamplejava.data.ApiConst;
import nacc.sergey.retrofitexamplejava.data.Hero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyViewModel extends ViewModel {

    //данные, которые будем получать асинхронно
    private MutableLiveData<List<Hero>> heroList;

    //вызываем этот метод для получения данных
    public LiveData<List<Hero>> getHeroes() {

        //если список нулевой
        if (heroList == null) {
            heroList = new MutableLiveData<List<Hero>>();
            //будем загружать его асинхронно с сервера в этом методе
            loadHeroes();
        }
        //вернем готовый список
        return heroList;
    }

    //метод использует Retrofit для получения данных JSON из URL
    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                //устанавливаем список для наших MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
            }
        });
    }
}

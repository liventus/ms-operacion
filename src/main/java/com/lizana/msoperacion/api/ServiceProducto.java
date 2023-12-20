package com.lizana.msoperacion.api;


import com.lizana.msoperacion.model.dto.OperacionDto;

import com.lizana.msoperacion.model.externoproduct.StatusResponse;
import com.lizana.msoperacion.util.ValidacionOperacion;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;


public class ServiceProducto {
    public interface ProductService {
        @GET("/product")
        @Headers("Content-Type: application/json")
        Single<StatusResponse> getProduct(@Header("productId") String productId);
    }

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static Maybe<StatusResponse> serviceProductWc(OperacionDto dto) {
        Retrofit retrofit = getRetrofitInstance();
        ProductService productService = retrofit.create(ProductService.class);



        // aca estoy mandando a buscasr el producto con el idSaldo
        return productService.getProduct(dto.getIdSaldo())
                .toMaybe();
    }
}
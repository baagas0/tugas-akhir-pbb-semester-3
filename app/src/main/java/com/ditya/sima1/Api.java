package com.ditya.sima1;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Api {
    String BASE_URL = "http://192.168.88.97/api/v1/student/";

    @Headers({
            "Accept: application/json",
//            "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTY0Nzc2MjBmMzcwOWFhYTg1YmE0YzE3NjI1ZmZlMzM5NDM0YTI1YzdhMzEzOTk3YTNlMGU3MmUxMjU5MzUzZDk3ZjE1MGUzNmM2ZmM2ODciLCJpYXQiOjE2NzE3MjI3OTksIm5iZiI6MTY3MTcyMjc5OSwiZXhwIjoxNzAzMjU4Nzk4LCJzdWIiOiIxMjIiLCJzY29wZXMiOltdfQ.KN0B-bh0rrNNgbl1ZcG1dNuP7bXStYTkopf0DctPkI05nFbCNs5p7KfsR-O7vqQA887wWcpjCi5QrS9rFGo0VI8NSPhSyu-93FDu5ovUAWi07xx9ODCV1XHCFFBQmwjedtclK1_RBS0FEkKPU5bB2ma1nZfRkpwUOnNkEyU9F6a3AOnnJo5shRriF_NatgfXZIMvGxUNF9Hjy2FaOqylnN6TCHC5Ligb5Bgb3WNeJ6GDm7loAawltBizKbP3Zh2wneVn3I7XBwv6NtbcgyEz9i1toWN0z9fdOLVIlNP0dpdPjk5b8Ta4SJedHC9cR_5GdqHmpIolfefk4uPeySvX3-K-wNfkGze2z62kqwvSDF2hH9uX5a9sGOG8p5HRUX-vLye6VGXX6RPzPyUWZ_wB21TEVE0oGZ5Lj4yFV646i-GYH2JOwdhXuPuwbKxaTwi7J2e--5HU9JevquIYQOeu9kBjD9dQ0e2HVbb6zOLYg7_E3SFSFZuUAOEQsTQgi3luoMaldZpuTpEAiayliPGllr7oe1N4bYGCqJeVBMB3jDtLqu_w7XMpOEwB-5TuRJTh1O9GlXgnR8Y1ETjgoZMLKLYxWJZRTAIWa2togRnNvn2ZkMKPVjE5HkH0Plozx7Y3k-6J0-7Yz8u102vhjZ4hcu12gHT409Ru0sazOXRu8Kc"
    })

    @GET("absence/check")
    Call<List<ModelAbsentHistory>> getAbsenceCheck(@Header("authorization") String auth, @QueryMap Map<String, String> params);

    @POST("login")
    Call<List<ModelLogin>> postLogin(@Body Credentials credentials);
}

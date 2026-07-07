package com.yamuna;

public class MyService {
    private final ExternalApi externalApi;
    public  MyService(ExternalApi ep)
    {
        this.externalApi = ep;
    }

    public String fetchData()
    {
        return externalApi.getData();
    }

}

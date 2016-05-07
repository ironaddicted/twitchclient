package com.avoinovan.twitchclient.api;

import com.avoinovan.twitchclient.api.model.RestStream;
import com.avoinovan.twitchclient.api.model.response.MultiStreamsSearchResult;
import com.avoinovan.twitchclient.api.model.response.SingleStreamSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by avoinovan on 4/29/16.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TwitchApiClient {

    static private int RESULTS_PER_PAGE = 100;

    @Value("${twitch.api.url}")
    private String twitchApiUrl;

    @Autowired
    private RestTemplate restTemplate;


    public List<RestStream> getChannelsWithViewersGt(final Integer minViewersCount, final String gameName, Integer pageNo) {

        //List<RestStream> result = new LinkedList<>();

        String uri = "/search/streams?limit={limit}&offset={offset}&type=suggest&q={gameName}";

        MultiStreamsSearchResult searchResult = restTemplate.getForObject(twitchApiUrl + uri, MultiStreamsSearchResult.class, RESULTS_PER_PAGE, pageNo * RESULTS_PER_PAGE, gameName);

        //result.addAll(searchResult.getResults().parallelStream().filter(stream -> stream.isOnline() && gameName.equals(stream.getGame()) && stream.getViewers() >= 100).collect(Collectors.toList()));

        return searchResult.getResults().parallelStream().filter(stream -> stream.isOnline() && gameName.equals(stream.getGame()) && stream.getViewers() >= minViewersCount).collect(Collectors.toList());

/*        int currentPage = 1;

        while(RESULTS_PER_PAGE * currentPage < searchResult.getTotal()) {
            searchResult = restTemplate.getForObject(searchResult.getLinks().getNext(), MultiStreamsSearchResult.class );

            result.addAll(searchResult.getResults()
                    .parallelStream().filter(stream -> stream.isOnline() && gameName.equals(stream.getGame()) && stream.getViewers() >= minViewersCount).collect(Collectors.toList()));
            currentPage++;
        }*/

        //return result;
    }

    public RestStream getStreamByChannel(String channelName) {

        try {

            String uri = "/streams/{channelName}";

            return restTemplate.getForObject(twitchApiUrl + uri, SingleStreamSearchResult.class, channelName).getResult();
        } catch (Exception e) {
            return null;
        }
    }
}

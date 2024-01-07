package uk.ac.bcu.oluwatobi.hrapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import uk.ac.bcu.oluwatobi.hrapp.dto.DataResponse;
import uk.ac.bcu.oluwatobi.hrapp.model.PipelineModelType;

@Service
public class LLMPipelineService implements PipelineService{


    @Value("${pipeline-service.address}")
    private String apiUrl;

    Logger logger = LoggerFactory.getLogger(LLMPipelineService.class);

    private final WebClient webClient;

    public LLMPipelineService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(this.apiUrl).build();
    }

    @Override
    public <T> void sendData(T data, PipelineModelType modelType) {
        var mono = this.webClient.post()
                .uri(String.format("%s/pipeline/process-data/new/%s", this.apiUrl, modelType.getValue()))
                .bodyValue(data)
                .retrieve()
                .bodyToMono(Object.class);
        mono.subscribe((value) -> {
            logger.info(String.format("%s %s","PIPELINE RESPONSE MESSAGE:", value.toString()));
        });
    }
}

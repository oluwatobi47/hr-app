package uk.ac.bcu.oluwatobi.hrapp.service;

import uk.ac.bcu.oluwatobi.hrapp.model.PipelineModelType;

public interface PipelineService {
//    <T> void sendData(T data);
    <T> void sendData(T data, PipelineModelType modelType);
}

package com.devfelix.elderlyService.dto;

import java.util.List;

public record WorkerCapabilityDto (long workerId, List<String> capabilities){
}

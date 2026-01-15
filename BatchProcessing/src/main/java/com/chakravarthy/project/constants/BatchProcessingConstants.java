package com.chakravarthy.project.constants;

import java.util.List;

public final class BatchProcessingConstants {

    public static final String FILE_VALIDATION_COUNT = "${batch.validation.count}";
    public static final String BATCH_VALIDATION_SOURCESYSTEM = "#{'${batch.validation.sourcesystem-abbrevations}'.split(',')}";
    public static final String JSON_DOT = ".json";
    public static final String PATH_DELIMITER = "/";
}

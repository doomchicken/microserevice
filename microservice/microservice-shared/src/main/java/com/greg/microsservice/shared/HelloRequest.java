package com.greg.microsservice.shared;

import javax.validation.constraints.NotNull;

public record HelloRequest(@NotNull String text) {
}

package com.greg.microsservice.shared.model;

import javax.validation.constraints.NotNull;

public record TextDoubleRequest(@NotNull String text) {
}

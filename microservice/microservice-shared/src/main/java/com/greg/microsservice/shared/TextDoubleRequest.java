package com.greg.microsservice.shared;

import javax.validation.constraints.NotNull;

public record TextDoubleRequest(@NotNull String text) {
}

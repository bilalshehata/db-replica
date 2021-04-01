package com.atlassian.db.replica.internal;

import com.atlassian.db.replica.spi.SuppliedCache;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * No cache implementation
 */
public class NoCacheSuppliedCache<T> implements SuppliedCache<T> {
    @Override
    public Optional<T> get(Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get());
    }
}

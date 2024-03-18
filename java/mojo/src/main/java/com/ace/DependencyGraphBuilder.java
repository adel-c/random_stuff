package com.ace;

import org.apache.maven.project.DependencyResolutionRequest;
import org.apache.maven.project.DependencyResolutionResult;

public interface DependencyGraphBuilder {
    DependencyResolutionResult resolveDependencies(DependencyResolutionRequest request);
}

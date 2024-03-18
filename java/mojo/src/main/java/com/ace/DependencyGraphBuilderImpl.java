package com.ace;

import org.apache.maven.project.DependencyResolutionException;
import org.apache.maven.project.DependencyResolutionRequest;
import org.apache.maven.project.DependencyResolutionResult;
import org.apache.maven.project.ProjectDependenciesResolver;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DependencyGraphBuilderImpl implements DependencyGraphBuilder {
//    private final ProjectDependenciesResolver resolver;
//
//    @Inject
//    public DependencyGraphBuilderImpl(ProjectDependenciesResolver resolver) {
//        this.resolver = resolver;
//    }

    @Override
    public DependencyResolutionResult resolveDependencies(DependencyResolutionRequest request)  {
//        try {
//            return resolver.resolve(request);
//        } catch (DependencyResolutionException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }
}

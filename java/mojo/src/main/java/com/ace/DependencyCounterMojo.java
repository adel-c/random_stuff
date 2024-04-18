package com.ace;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.*;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.graph.DependencyFilter;
import org.eclipse.aether.graph.DependencyNode;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.COMPILE)
public class DependencyCounterMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;
    @Parameter(defaultValue = "${session}", readonly = true, required = true)
    private MavenSession session;
    private DependencyGraphBuilder graphBuilder;
    @Inject
    public DependencyCounterMojo( DependencyGraphBuilder component )
    {
        this.graphBuilder = component;
    }
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencies = project.getDependencies();
        ProjectBuildingRequest buildingRequest = session.getProjectBuildingRequest();

        MavenProject project = buildingRequest.getProject();

        RepositorySystemSession session = buildingRequest.getRepositorySession();

        buildingRequest.setProject(project);

        final DependencyResolutionRequest request = new DefaultDependencyResolutionRequest();
        request.setMavenProject(project);
        request.setRepositorySession(session);
        // only download the poms, not the artifacts
        DependencyFilter collectFilter = (node, parents) -> false;
        request.setResolutionFilter(collectFilter);

        final DependencyResolutionResult result;
        result = graphBuilder.resolveDependencies(request);
        DependencyNode dependencyGraph = result.getDependencyGraph();

        org.eclipse.aether.graph.DependencyNode graph = result.getDependencyGraph();
        long numDependencies = dependencies.stream().count();
        getLog().info("Number of dependencies: " + numDependencies);
    }


}

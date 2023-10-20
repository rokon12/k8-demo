# Helm Chart Deployment Guide for Spring Boot and PostgreSQL

## Preliminary Setup

### Install Docker Desktop and Enable Kubernetes

1. Download and install Docker Desktop from [Docker's official website](https://www.docker.com/products/docker-desktop).
2. Open Docker Desktop and navigate to **Settings > Kubernetes**.
3. Check the box for **Enable Kubernetes** and click on **Apply & Restart**.

### Install Java 21 Using SDKMAN

1. Install SDKMAN by running the following command:

    ```bash
    curl -s "https://get.sdkman.io" | bash
    ```

2. Open a new terminal window and install Java 21:

    ```bash
    sdk install java 21.0.0
    ```

### Use Gradle to Build the Project

1. Navigate to your Spring Boot project directory.
2. Run the following command to build the project using Gradle:

    ```bash
    ./gradlew build
    ```

This will generate a JAR file in the `build/libs/` directory.

### Run Docker Compose Locally

1. Make sure you have a `docker-compose.yaml` file at the root of your project.
2. Run the following command to bring up the services:

    ```bash
    docker-compose up --build
    ```

3. Open a browser and navigate to `http://localhost:8080/hello` to ensure that the application is running as expected.

### Build Docker Image

Run the following command to build a Docker image for your Spring Boot application:

```bash
docker build -t helloworld-spring-boot-app:latest .
```

## Helm Chart Directory Structure

Your Helm chart directory should look like this:

```plaintext
my-helm-chart/
├── templates/
│   ├── deployment.yaml
│   ├── postgres-service.yaml
│   └── springboot-loadbalancer-service.yaml
├── values.yaml
└── Chart.yaml
```

- **templates/**: Your Kubernetes YAML definitions.
- **values.yaml**: Configuration variables for your templates.
- **Chart.yaml**: Metadata about the Helm chart.

## Creating Basic Helm Chart Files

1. **Chart.yaml**: This file should contain meta-information about the Helm chart.

    ```yaml
    apiVersion: v2
    name: my-helm-chart
    version: 0.1.0
    ```

2. **values.yaml**: This file should hold configurable parameters that will be fed into your templates. See example values for Spring Boot and PostgreSQL configurations.

3. **deployment.yaml**: This file should contain the Deployment configuration for your Spring Boot application, including any environment variables it might need.

4. **postgres-service.yaml**: This file should define a Kubernetes Service for your PostgreSQL database, as well as a Deployment to manage the database Pods.

### Deploy Helm Chart

Once your Helm chart is ready, you can deploy it to your Kubernetes cluster:

1. Lint the chart to catch issues:
   ```bash
   helm lint ./my-helm-chart
   ```

2. Package the chart:
   ```bash
   helm package ./my-helm-chart
   ```

3. Deploy the chart:
   ```bash
   helm install my-helm-release ./my-helm-chart
   ```
---

That's it! You now have a Helm chart for deploying a Spring Boot application and PostgreSQL database, complete with a LoadBalancer and health checks.

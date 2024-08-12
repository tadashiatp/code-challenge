FROM ghcr.io/graalvm/native-image-community:21 AS build
RUN microdnf install findutils
WORKDIR /app
COPY . .
RUN ./gradlew nativeCompile

FROM alpine
WORKDIR /app
COPY --from=build /app/build/native/nativeCompile/caqui /app/caqui
CMD [ "/app/caqui" ]
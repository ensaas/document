FROM gcr.io/distroless/base
COPY example /example
COPY /charts /charts

EXPOSE 8080

CMD ["/example --insecure --port 8080"]
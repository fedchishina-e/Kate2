CMD cd /app/bin && ./start.sh
CMD cd /app/bin && ./start.sh
CMD ["cd", "/app/bin", "&&", "./start.sh"]
ENTRYPOINT cd /app/bin && ./start.sh
ENTRYPOINT ["cd", "/app/bin", "&&", "./start.sh"]
RUN cd /app/bin && ./start.sh
RUN ["cd", "/app/bin", "&&", "./start.sh"]

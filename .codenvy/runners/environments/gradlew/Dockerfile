FROM codenvy/jdk7
RUN mkdir /home/user/app
WORKDIR /home/user/app
ADD $app$ /home/user/$app$
RUN unzip -q /home/user/$app$ -d /home/user/app && \
    rm /home/user/$app$
RUN chmod +x gradlew
CMD ./gradlew build

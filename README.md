# Covid Track
### A simple Patient record management system

![Screenshot](https://github.com/shouryalala/gae-java-covid-track/blob/master/screenshot.jpg)

This project demonstrates the use of the Google App Engine. It also uses Cloud Firestore to store and retrieve data in real-time and uses firestore storage for images.

This project is built on top of the [getting started guide](https://cloud.google.com/java/getting-started-appengine-standard/tutorial-app) and is meant to help users get started with GAE quickly.

Instructions to get started are simple:
1. Create a Google Account if you dont have one
2. Visit [Google Cloud Console](https://console.cloud.google.com/)
3. Create a new project and follow the setup flow as directed
4. You can use one of the tutorials provided to understand the configs required
5. Clone this repository to the cloud directory. Then you can start testing it in gcloud itself. 

### Running Locally

To run your project locally:

* Set the `BOOKSHELF_BUCKET` environment variable:

      export BOOKSHELF_BUCKET=<YOUR_BUCKET_NAME>

  Where <YOUR_BUCKET_NAME> is the bucket you created above.
* Run with the Jetty Maven plugin:

      mvn jetty:run-exploded

**Note**: If you run into an error about `Invalid Credentials`, you may have to run:

    gcloud auth application-default login

### Deploying to Cloud Run

To build your image:

* Update the parameters in `pom.xml`:
  * Replace `MY_PROJECT` with your project ID.
* Build and deploy to your GCR with [Jib][jib] Maven plugin.

      mvn clean package jib:build
* Deploy the app to Cloud Run:

      gcloud beta run deploy bookshelf --image gcr.io/<MY_PROJECT>/bookshelf \
            --platform managed --region us-central1 --memory 512M \
            --update-env-vars BOOKSHELF_BUCKET="<YOUR_BUCKET_NAME>"

Where <MY_PROJECT> is the name of the project you created.

This command will output a link to visit the page.


You can use these links for more info:
- [Running/Deploying](https://cloud.google.com/java/getting-started/jib?hl=fa)
- [Bookshelf Sample Project](https://cloud.google.com/java/getting-started-appengine-standard/tutorial-app)

# Create a Next.js App and Deploy to Azure

**Sources**

* [Next.js doc to create an app](https://nextjs.org/learn/basics/create-nextjs-app)
* [Next.js doc to deploy app to Github](https://nextjs.org/learn/basics/deploying-nextjs-app/github)
* [Next.js app example](https://next-learn-starter.vercel.app/)
* [Deploy Next.js App to Azure](https://learn.microsoft.com/en-us/azure/static-web-apps/deploy-nextjs-hybrid)
* [Custom Domain in Azure Static Web Apps](https://learn.microsoft.com/en-us/azure/static-web-apps/custom-domain)
* [What is Azure Static Web Apps](https://learn.microsoft.com/en-us/azure/static-web-apps/overview)
* [Install Node with NVM](https://github.com/nvm-sh/nvm#installing-and-updating)

## Create GitHub repo

Created a repo called `azureblog` for all my Azure related tutorials and lessons learned.

* Don't add a `README`

## Install Node in Ubuntu

Using the default `sudo apt install nodejs npm` doesn't work with Next.js, since it requires `v.14` and above, and `apt` version is `v.12`.

Tried using Nodesource but running the commands returned an error that I couldn't figure out. (Wasted about 2 hrs here)

Install with NVM (took 5 minutes)

    cd ~/
    git clone https://github.com/nvm-sh/nvm.git .nvm
    cd ~/.nvm
    git checkout v0.39.3
    . ./nvm.sh

Add to `~/.bashrc`

    export NVM_DIR="$HOME/.nvm"
    [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
    [ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"  # This loads nvm bash_completion

List all available versions:

    nvm ls-remote

Install the latest LTS (`v18.14.1` as of Feb 2023):

    nvm install --lts

Verify that it was installed:

    $ node -v
    v18.14.1
    $ npm -v
    9.3.1

## Create a Next.js app

Use this command with the name of the github repo.

    npx create-next-app@latest azureblog --use-npm --example "https://github.com/vercel/next-learn/tree/master/basics/learn-starter"

Output:

    Creating a new Next.js app in /home/tom/azureblog.
    Downloading files from repo https://github.com/vercel/next-learn/tree/master/basics/learn-starter. This might take a moment.
    Installing packages. This might take a couple of minutes.
    added 18 packages, and audited 19 packages in 10s
    found 0 vulnerabilities
    Initialized a git repository.
    Success! Created azureblog at /home/tom/azureblog
    Inside that directory, you can run several commands:

    npm run dev
        Starts the development server.
    npm run build
        Builds the app for production.
    npm start
        Runs the built app in production mode.
    We suggest that you begin by typing:
    cd azureblog
    npm run dev

Open the directory

    cd azureblog

Add the git remote

    git remote add origin your-repo

Start the server

    npm run dev

Output:

    > dev
    > next dev

    ready - started server on 0.0.0.0:3000, url: http://localhost:3000
    event - compiled client and server successfully in 2.4s (149 modules)
    Attention: Next.js now collects completely anonymous telemetry regarding usage.
    This information is used to shape Next.js' roadmap and prioritize features.
    You can learn more, including how to opt-out if you'd not like to participate in this anonymous program, by visiting the following URL:
    https://nextjs.org/telemetry

Open localhost `http://localhost:3000`

## Initial push to Github

    git push -u origin main

## Create a static web app in Azure

Go to Azure portal:

* Create a resource
* Search `Static Web apps`
* Select `Create`

Basics:

* Select Subscription, Resource Group
* Enter a name
* Plan type: Free
* Region: Select your closest one
* Source: GitHub
* GitHub account: `Sign in with GitHub`

After sign in with Github:

* Choose (your Github account) Organization
* Select Repository
* Select Branch

Build Details:

* Build presets, select `Next.js`
* App location, leave default `/`

Review and create:

* Select `Review and Create`, then `Create`
* When completed `Go to resource`

## Check first deployment to Azure

Status of (actual) deployment:

* Azure shows a link for the deployed app. However, it said "waiting for the content"
* Go to the `Actions` workflow in the Github repo.
* It took about 2 minutes to complete
* Then check again the Azure link.
* It shows the default `Welcome to Next.js`

The Azure docs say that changes must be synced with local repo.

"When you created the app, Azure Static Web Apps created a GitHub Actions file in your repository. Synchronize with the server by pulling down the latest to your local repository"

Looking at GitHub, a new directory was created `.github/workflows` with a `yml` file. Some of the code:

        name: Azure Static Web Apps CI/CD

        on:
        push:
            branches:
            - main
        pull_request:
            types: [opened, synchronize, reopened, closed]
            branches:
            - main

Update local repo:

    $ git pull origin main

## Push/Deploy new changes

Looking at the `yml` script, it deploys once you push to the repo. Also the doc on `Azure Static Web Apps` says:

"...Azure interacts directly with GiHub or Azure DevOps, to monitor a branch...every time you push commits or accept pull requests into the watched branch, a build automatically runs and your app and API deploys to Azure"

Deploy to Azure pushing to GitHub:

    git push -u origin main

## Create a custom domain for the Azure generated URL

Go to Azure portal and get a `TXT` to validate that you own the domain:

* Azure Portal
* Go to the static web app resource
* Left menu/Settings/Custom domains
* Add
* `Custom domain on other DNS`
* Enter domain name
* Create `TXT` record
* Add settings to your DNS provider

With your DNS provider, create a `CNAME` record

* Type: `CNAME`
* Host: Your subdomain
* Value: Azure generated URL (without https://)

Wait a few hours to resolve.

## Build the Blog in Next.js

Run the server and keep it running.

    npm run dev

Following the official Next.js docs [here](https://nextjs.org/learn/basics/create-nextjs-app/editing-the-page)

**Edit a page**

Open `pages/index.js`. Replace `Welcome to` with `Learn`

**Create a new page**

* Under `pages` create the directory `posts`
* Create the file `first-post.js`

Add this content:

    export default function FirstPost() {
        return <h1>First Post</h1>;
    }

Then go to `http://localhost:3000/posts/first-post`

**Link Component**

In `pages/index.js` add:

    import Link from 'next/link';

Change the `h1` to:

    <h1 className="title">
        Read <Link href="/posts/first-post">this page</Link>
    </h1>

In `pages/posts/first-post.js` replace contents with:

    import Link from 'next/link';

    export default function FirstPost() {
        return (
            <>
                <h1>First Post</h1>
                <h2>
                    <Link href="/">Back to home</Link>
                </h2>
            </>
        );
    }

**Create a profile picture**

* Save a `profile.jpg` (400x400px) in `public/images`
* Remove the default `public/vercel.svg`
* Replace your favicon or leave the default in `public/favicon.ico`

**Modify the Metadata**

Add `Head` to `first-post.js`

    import Head from 'next/head';

Update the `FirstPost` component and include `Head`

    ...
    <>
        <Head>
            <title>First Post</title>
        </Head>
        <h1>First Post</h1>
    ...

**Create a Layout to share on all pages**

* Create a top level `components` directory
* Inside create a `layout.js`

Add this content:

    export default function Layout({ children }) {
        return <div>{children}</div>;
    }

In `pages/posts/first-post.js` add `Layout` import. Enclose everything in `return` with the `Layout` component, replacing the `<></>` with `<Layout></Layout`>.

    import Layout from '../../components/layout';

    ...
    return(
        <Layout>
        ...
        </Layout>
    );

Add CSS to `Layout`. Create a file `styles/Layout.module.css`:

    .container {
        max-width: 36rem;
        padding: 0 1rem;
        margin: 3rem auto 6rem;
    }

    .header {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .backToHome {
        margin: 3rem 0 0;
    }

Modify `components/layout.js` with:

    import styles from '../styles/Layout.module.css';

    export default function Layout({ children }) {
        return <div className={styles.container}>{children}</div>;
    }

**Add Global Style**

Create the file `pages/_app.js`:

    export default function App({ Component, pageProps }) {
        return <Component {...pageProps} />;
    }

Restart the server.

Modify `styles/global.css` adding:

    body {
        line-height: 1.6;
        font-size: 18px;
    }

    a {
        color: #0070f3;
    }

    a:hover {
        text-decoration: underline;
    }

    img {
        max-width: 100%;
        display: block;
    }

Import the file  in `pages/_app.js`:

    import '../styles/globals.css';

Review results in `localhost:3000/posts/first-post`

**Adding Google Analytics JavaScript**

* [Adding external JS in Next.js](https://nextjs.org/docs/basic-features/script)
* [Add Google Analytics to Next.js](https://mariestarck.com/add-google-analytics-to-your-next-js-application-in-5-easy-steps/)
* [Another about adding GA to Next](https://enlear.academy/add-google-analytics-to-a-next-js-application-5525892844db)

In Google Analytics `GA4`, in your account, create a property, create a data stream, and get the Google tag `Install manually`. Copy the JS code.

Create the file `.env.local` in the root directory with this:

    NEXT_PUBLIC_GOOGLE_ANALYTICS='G-YourCodeHere'

Add this file to `.gitignore`. It might be already added:

    .env.local

Go to `pages/_app.js`, import:

    import Script from 'next/script';

Add the Google Analytics script in the `_app.js` file:

    export default function App({ Component, pageProps }) {
        return (
            <>
                <Script
                    src={`https://www.googletagmanager.com/gtag/js?id=${process.env.NEXT_PUBLIC_GOOGLE_ANALYTICS}`}
                    strategy="afterInteractive"
                    onLoad={() => {
                        console.log('GA script has loaded')
                    }}
                />
                <Script
                    id="google-analytics"
                    strategy="afterInteractive"
                    dangerouslySetInnerHTML={{
                        __html: `
                        window.dataLayer = window.dataLayer || [];
                        function gtag() {
                            dataLayer.push(arguments);
                            gtag('js', new Date());
                            gtag('config', '${process.env.NEXT_PUBLIC_GOOGLE_ANALYTICS}');
                        }`
                    }}
                />
                <Component {...pageProps} />
            </>
        );
    }

Go to the browser's console to see if the JS was loaded.

Add the environment variable in Azure:

* Go to the Azure static web app
* Settings/Configuration
* Application settings
* Environment: Production
* Click `Add`
* Enter name: `NEXT_PUBLIC_GOOGLE_ANALYTICS`
* Enter value: `G-YourCodeHere`

**Polish the Layout**

As seen in the Next.js docs [here](https://nextjs.org/learn/basics/assets-metadata-css/polishing-layout)

Update these files with your content, or with content from the website above.

* Add a file `styles/utils.module.css`
* Update `components/layout.js`
* Update `pages/index.js`

**Create the blog structure**

As seen in the Next.js docs [here](https://nextjs.org/learn/basics/data-fetching/blog-data)

* Create the directory `posts` in project root
* Add markdown blog posts in this folder

Example `posts/pre-rendering.md`

    ---
    title: 'Two Forms of Pre-rendering'
    date: '2020-01-01'
    ---

    Next.js has two forms of pre-rendering

Install the library to parse the yaml metadata:

    npm install gray-matter

Create the directory `lib` in the project root. Then create a file `lib/posts.js`. Copy the code from the docs.

In `pages/index.js` add the code as seen [here](https://nextjs.org/learn/basics/data-fetching/implement-getstaticprops). This will add the list of blog posts to the home page.

**Create dynamic routes for the blog posts**

As seen in the docs [here](https://nextjs.org/learn/basics/dynamic-routes/page-path-external-data)

* In `page/posts/` create the file `[id].js`
* Remove the file `pages/posts/first-post.js`
* Add the code as seen in the docs.

## Wrapping up creating the app

Around this point following the Next.js docs, I realized this was way too much JS for me. It's a great learning experience if you wish to study and understand every single line of code. I completed all the files and added the code. Then deployed the final result to Azure.

## Creating blog posts

I created a Markdown template and included this file in `.gitignore`. I just copy/paste the template to `posts` and modify it to create a new blog post. Then git commit and `git push -u origin main` to deploy the blog to Azure.



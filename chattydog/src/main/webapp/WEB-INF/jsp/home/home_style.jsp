<style>
    @import url(https://fonts.googleapis.com/css?family=Montserrat);

    /*basic reset*/
    * {margin: 0; padding: 0;}

    html {
        height: 100%;
        /*Image only BG fallback*/

        /*background = gradient + image pattern combo*/
        background:
                linear-gradient(rgba(196, 102, 0, 0.6), rgba(155, 89, 182, 0.6));
    }

    body {
        font-family: montserrat, arial, verdana;
    }
    /*form styles*/
    card {
        width: 300px;
        margin: 50px auto;
        text-align: center;
        position: relative;
    }

    /*buttons*/
    .action-button {
        width: 200px;
        background: #177245;
        font-weight: bold;
        color: white;
        border: 0 none;
        border-radius: 1px;
        cursor: pointer;
        padding: 10px 5px;
        margin: 10px 5px;
    }
    .action-button:hover, .action-button:focus {
        box-shadow: 0 0 0 2px white, 0 0 0 3px #27AE60;
    }
    /*headings*/
    .fs-title {
        font-size: 15px;
        text-transform: uppercase;
        color: #2C3E50;
        margin-bottom: 10px;
    }
    .fs-subtitle {
        font-weight: normal;
        font-size: 13px;
        color: #666;
        margin-bottom: 20px;
    }
    /*progressbar*/
    #progressbar {
        margin-bottom: 30px;
        overflow: hidden;
        /*CSS counters to number the steps*/
        counter-reset: step;
    }
    #main {
        background-color: #f2f2f2;
        position: relative;
        padding: 20px;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        -ms-border-radius: 4px;
        -o-border-radius: 4px;
        border-radius: 4px;
        border-bottom: 4px #ddd;
    }
    #real-estates-detail #author img {
        -webkit-border-radius: 100%;
        -moz-border-radius: 100%;
        -ms-border-radius: 100%;
        -o-border-radius: 100%;
        border-radius: 100%;
        border: 5px solid #ecf0f1;
        margin-bottom: 10px;
    }
    #real-estates-detail .sosmed-author i.fa {
        width: 30px;
        height: 30px;
        border: 2px solid #bdc3c7;
        color: #bdc3c7;
        padding-top: 6px;
        margin-top: 10px;
    }
    .panel-default .panel-heading {
        background-color: #fff;
    }
    #real-estates-detail .slides li img {
        height: 450px;
    }
    .navbar-nav {
        float: none;
        text-align: center;
    }
    .navbar-nav li {
        float: none;
        display: inline-block;
    }

</style>
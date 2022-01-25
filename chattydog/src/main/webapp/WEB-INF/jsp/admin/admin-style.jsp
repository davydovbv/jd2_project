<style>
    @import url(https://fonts.googleapis.com/css?family=Montserrat);

    /*basic reset*/
    * {margin: 0; padding: 0;}

    html {
        height: 100%;
        /*Image only BG fallback*/

        /*background = gradient + image pattern combo*/
    }

    body {
        font-family: montserrat, arial, verdana;
    }

    a{
        text-decoration: none;
        color: black;
    }

    .page {
        max-height: calc(100vh - 3.5rem);
        overflow: auto;
    }

    /*form styles*/
    .card {
        width: 50%;
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
    #user_result{
        background-color: #f2f2f2;
        position: relative;
        padding: 20px;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        -ms-border-radius: 4px;
        -o-border-radius: 4px;
        border-radius: 4px;
        border-bottom: 4px;
        border-top: 4px;
        border-right: 4px;
        border-left: 4px;
    }
    .img {
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
     img {
        height: 100px;
    }

    table {
        text-align: center;
        table-layout: fixed;
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
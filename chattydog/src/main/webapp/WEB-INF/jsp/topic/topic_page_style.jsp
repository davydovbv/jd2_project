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

    a {
        text-decoration: none;
        color: black;
    }

    .container {
        width: 70%;
        margin: 50px auto;
        text-align: center;
        position: relative;
    }

    .topic {
        background: white;
        border: 0 none;
        border-radius: 3px;
        box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
        padding: 20px 30px;
        box-sizing: border-box;
        width: 80%;
        margin: 15px 10%;
    }
    .theme {
        text-align: center;
        font-size: x-large;
    }

    .author {
        text-align: right;
        font-size: larger;
    }

    .button_class {
        text-align: right;
        font-size: medium;
    }

    .description {
        text-align: center;
        font-size: large;
    }

    .message{
        background: white;
        border: 0 none;
        border-radius: 3px;
        box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
        padding: 20px 30px;
        box-sizing: border-box;
        width: 80%;
        margin: 15px 10%;
    }

    .message_author {
        text-align: right;
        font-size: small;
    }

    .message_content {
        text-align: left;
        font-size: medium;
    }


    /*form styles*/
    #msform {
        width: 400px;
        margin: 50px auto;
        text-align: center;
        position: relative;
    }
    #msform fieldset {
        background: white;
        border: 0 none;
        border-radius: 3px;
        box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
        padding: 20px 30px;
        box-sizing: border-box;
        width: 80%;
        margin: 0 10%;

        /*stacking fieldsets above each other*/
        position: relative;
    }
    /*Hide all except first fieldset*/
    #msform fieldset:not(:first-of-type) {
        display: none;
    }
    /*inputs*/
    #msform input, #msform textarea {
        padding: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
        margin-bottom: 10px;
        width: 100%;
        box-sizing: border-box;
        font-family: montserrat;
        color: #2C3E50;
        font-size: 13px;
    }
    /*buttons*/
    #msform .action-button {
        width: 100px;
        background: #177245;
        font-weight: bold;
        color: white;
        border: 0 none;
        border-radius: 1px;
        cursor: pointer;
        padding: 10px 5px;
        margin: 10px 5px;
    }
    #msform .action-button:hover, #msform .action-button:focus {
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

    .button{
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


</style>
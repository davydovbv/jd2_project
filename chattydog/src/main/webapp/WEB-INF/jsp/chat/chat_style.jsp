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

    a {
        text-decoration: none;
        color: black;
    }

    .page {
        max-height: calc(100vh - 3.5rem);
        overflow: auto;
    }

    .chats_container {
        width: 30%;
        float: left;
        display: block;
        margin: 30px auto;
        text-align: center;
    }
    .chat_container {
        text-align: center;
    }

    .chat {
        background: white;
        border: 0 none;
        border-radius: 3px;
        box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
        padding: 20px 30px;
        box-sizing: border-box;
        width: 80%;
        margin: 15px 10%;
    }
    .chat_name {
        text-align: center;
        font-size: medium;
    }

    .last_author {
        text-align: right;
        font-size: smaller;
    }

    .last_content {
        text-align: left;
        font-size: small;
    }



    .private_chat {
        background: white;
        border: 0 none;
        border-radius: 3px;
        box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
        padding: 20px 30px;
        box-sizing: border-box;
        width: 80%;
        margin: 15px 10%;
    }
    .private_chat_name {
        text-align: center;
        font-size: x-large;
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
        margin: 15px auto;
        text-align: center;
    }
    #msform fieldset {
        background: white;
        border: 0 none;
        border-radius: 3px;
        box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
        padding: 20px 30px;
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
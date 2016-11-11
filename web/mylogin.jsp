<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a Flat Login/Sign up Page with Validator jQuery Plugin</title>
    <link href="css/style.css" media="screen" rel="stylesheet">
    <link href="css/reset.css" media="screen" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,600italic,700italic,800italic,400,300,600,800'
          rel='stylesheet' type='text/css'>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/validator.js"></script>

</head>
<body>
<div class="container">
    <div class="flat-design-form">
        <ul class="tabs">
            <li><a class="active" href="#login" id="login-tab"> Login</a></li>
            <li><a href="#register" id="register-tab">Registration</a></li>
        </ul>

        <div class="form-display show" id="login">
            <h1>Login</h1>

            <form action="" method="post" novalidate="">
                <fieldset>
                    <ul>
                        <li>
                            <div class="item">
                                <input class='email' name="email"
                                       placeholder="Email" required="required"
                                       type="email">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input name="password" placeholder="Password" required=
                                        'required' type="password">
                            </div>
                        </li>

                        <li><input class="button-login" type="submit"
                                   value="Login"></li>
                    </ul>
                </fieldset>
            </form>
        </div>

        <div class="form-display hide" id="register">
            <h1>Registration</h1>

            <form action="" method="post" novalidate="">
                <fieldset>
                    <ul>

                        <li>
                            <div class="item">
                                <input class='email' name="email"
                                       placeholder="Email" required="required"
                                       type="email">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input name="password" placeholder="Password" required=
                                        'required' type="password">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input name="name" placeholder="Name" required=
                                        "required" type="text">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input name="surname" placeholder="Surname" required=
                                        "required" type="text">
                            </div>
                        </li>

                        <li><input class="button-register" id='send' type=
                                "submit" value="Sign Up"></li>
                    </ul>
                </fieldset>
            </form>
        </div>
    </div>
</div>


<script src="js/tabs.js"></script>


<script>
    // initialize the validator function
    validator.message['date'] = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
            .on('blur', 'input[required], input.optional, select.required', validator.checkField)
            .on('change', 'select.required', validator.checkField)
            .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required')
            .on('keyup blur', 'input', function () {
                validator.checkField.apply($(this).siblings().last()[0]);
            });

    // bind the validation to the form submit event
    //$('#send').click('submit');//.prop('disabled', true);

    $('form').submit(function (e) {
        e.preventDefault();
        var submit = true;
        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
            this.submit();
        return false;
    });

</script>
</body>
</html>


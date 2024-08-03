<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Employee Management Admin Dashboard</title>
<meta content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
	name="viewport" />
<link rel="icon" href="../assets/img/kaiadmin/favicon.ico"
	type="image/x-icon" />

<!-- Fonts and icons -->
<script src="../assets/js/plugin/webfont/webfont.min.js"></script>
<script>
        WebFont.load({
            google: {
                families: ["Public Sans:300,400,500,600,700"]
            },
            custom: {
                families: [
                    "Font Awesome 5 Solid",
                    "Font Awesome 5 Regular",
                    "Font Awesome 5 Brands",
                    "simple-line-icons",
                ],
                urls: ["../assets/css/fonts.min.css"],
            },
            active: function() {
                sessionStorage.fonts = true;
            },
        });
    </script>

<!-- CSS Files -->
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/plugins.min.css" />
<link rel="stylesheet" href="../assets/css/kaiadmin.min.css" />

<!-- CSS Just for demo purpose, don't include it in your project -->
<link rel="stylesheet" href="../assets/css/demo.css" />
</head>

<body>
	<div class="wrapper">
		<!-- Sidebar -->

		<!-- End Sidebar -->



		<div class="container">
			<div class="page-inner">

				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<div class="card">
							<div class="card-header">
								<div class="card-title">OTP VALIDATE</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-md-6 col-lg-12">

										<div class="form-group">
											<label for="password">OTP</label> <input type="password"
												id="otp" name="otp" class="form-control"
												id="otp" placeholder="OTP" required />
										</div>



										<center><span id="errorMsg" style="color: red;"></span></center>


									</div>


								</div>
							</div>
							<div class="card-action">
								<button class="btn btn-success" onclick="sendRequest()">Submit</button>
								<button class="btn btn-danger">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

	<!-- Custom template | don't include it in your project! -->

	<!-- End Custom template -->
	</div>
	<!--   Core JS Files   -->
	<script type="text/javascript"> // URL of the API endpoint
	async function sendRequest() {
        const otp = document.getElementById('otp').value;
        const userData = sessionStorage.getItem('user');
        if (userData) {
            const user = JSON.parse(userData); // Parse the JSON string back into an object
            //return user.otp; // Access the OTP property
            if(user.otp===otp){
                window.location.href = 'dashboard'; // Replace with your actual next page URL

            }else{
           	 document.getElementById("errorMsg").textContent = 'Invalid OTP : ';

            }
        }
    }

	</script>

	<script src="../assets/js/core/jquery-3.7.1.min.js"></script>
	<script src="../assets/js/core/popper.min.js"></script>
	<script src="../assets/js/core/bootstrap.min.js"></script>

	<!-- jQuery Scrollbar -->
	<script
		src="../assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>

	<!-- Chart JS -->
	<script src="../assets/js/plugin/chart.js/chart.min.js"></script>

	<!-- jQuery Sparkline -->
	<script
		src="../assets/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

	<!-- Chart Circle -->
	<script src="../assets/js/plugin/chart-circle/circles.min.js"></script>

	<!-- Datatables -->
	<script src="../assets/js/plugin/datatables/datatables.min.js"></script>

	<!-- Bootstrap Notify -->
	<script
		src="../assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>

	<!-- jQuery Vector Maps -->
	<script src="../assets/js/plugin/jsvectormap/jsvectormap.min.js"></script>
	<script src="../assets/js/plugin/jsvectormap/world.js"></script>

	<!-- Google Maps Plugin -->
	<script src="../assets/js/plugin/gmaps/gmaps.js"></script>

	<!-- Sweet Alert -->
	<script src="../assets/js/plugin/sweetalert/sweetalert.min.js"></script>

	<!-- Kaiadmin JS -->
	<script src="../assets/js/kaiadmin.min.js"></script>

	<!-- Kaiadmin DEMO methods, don't include it in your project! -->
	<script src="../assets/js/setting-demo2.js"></script>
</body>

</html>
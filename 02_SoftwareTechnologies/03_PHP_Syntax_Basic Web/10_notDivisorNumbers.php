<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Not Divisor of Number</title>
</head>
<body>
	<form>
		<input type="text" name="num"/>
		<input type="submit"/>
		<?php
			if (isset($_GET['num'])) {
				echo "<br/>";
				$num = intval($_GET['num']);
				for ($i = $num; $i > 1; $i--) {
					if ($num % $i != 0) {
						echo $i . " ";
					}
				}
			}			
		?>
	</form>
</body>
</html>
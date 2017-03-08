<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Factorial</title>
</head>
<body>
	<form>
		<input type="text" name="num"/>
		<input type="submit"/>
		<?php
			if (isset($_GET['num'])) {
				$num = intval($_GET['num']);
				$f = 1;
				for ($i = 2; $i <= $num; $i++) {
					$f *= $i;
				}
				
				echo "<p>{$f}</p>";
			}			
		?>
	</form>
</body>
</html>
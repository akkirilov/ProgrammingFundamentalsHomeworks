<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Prime Numbers From N to One</title>
</head>
<body>
	<form>
		Number:
		<input type="text" name="num" />
		<input type="submit" />
	</form>
	<?php
		if (!isset($_GET['num']) || $_GET['num'] == "" || intval($_GET['num']) < 3){
			return;
		}
		
		$num = intval($_GET['num']);
		echo "<p>";
		for ($i = $num; $i >= 3; $i--) {
			$isPrime = true;
			for ($j = 2; $j < $i; $j++) {
				if ($i % $j == 0) {
					$isPrime = false;
					break;
				}
			}
			if ($isPrime) {
				echo $i . " ";
			}
		}
		echo "</p>";
	?>
</body>
</html>
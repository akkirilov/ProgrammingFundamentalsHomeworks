<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fibonacci Sequence</title>
</head>
<body>
	<form>
		Number:
		<input type="text" name="num" />
		<input type="submit" />
	</form>
	<?php
		if (!isset($_GET['num']) || $_GET['num'] == ""){
			return;
		}
		
		$num = intval($_GET['num']);
		if ($num < 3) {
			echo "<p>";
			for ($i = 0; $i < $num; $i++) {
				echo "1 ";
			}
			echo "</p>";
			return;
		}
		
		$fibA = 1;
		$fibB = 1;
		$fibC;
		echo "<p>" . $fibA . " ";
		echo $fibB . " ";
		
		for ($i = 2; $i < $num; $i++) {
			$fibC = $fibA + $fibB;
			echo $fibC . " ";
			$temp = $fibB;
			$fibA = $fibB;
			$fibB = $fibC;
		}
		echo "</p>";
	?>
</body>
</html>
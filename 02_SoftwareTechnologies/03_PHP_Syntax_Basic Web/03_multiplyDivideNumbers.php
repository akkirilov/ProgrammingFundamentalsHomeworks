<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MultiplyDivideNumbers</title>
</head>
<body>
	<form>
		N: 	
		<input type="text" name="num1" />
		M:
		<input type="text" name="num2" />
		<input type="submit" value="Send"/>
		<?php
			if (isset($_GET['num1']) && isset($_GET['num2'])) {
				$num1 = intval($_GET['num1']);
				$num2 = intval($_GET['num2']);
				$result = 0;
				
				if ($num2 >= $num1) {
					$result = $num1 * $num2;
				} else {
					$result = $num1 / $num2;
				}
				
				echo "<p>$result</p>";
			}
		?>
	</form>
</body>
</html>
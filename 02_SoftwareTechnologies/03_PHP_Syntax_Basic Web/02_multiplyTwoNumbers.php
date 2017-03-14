<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MultiplyTwoNumbers</title>
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
				$num = intval($_GET['num1']) * intval($_GET['num2']);
				echo "<p>$num</p>";
			}
		?>
	</form>
</body>
</html>
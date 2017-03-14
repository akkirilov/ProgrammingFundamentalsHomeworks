<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MultiplyByTwo</title>
</head>
<body>
	<form>
		N: 	
		<input type="text" name="num" />
		<input type="submit" />
		
		<?php
			if (isset($_GET['num'])) {
				$num = intval($_GET['num']) * 2;
				echo "<p>$num</p>";
			}
		?>
	</form>
</body>
</html>
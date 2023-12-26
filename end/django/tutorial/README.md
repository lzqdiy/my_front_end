①python download and install
# Create a virtual environment to isolate our package dependencies locally
pipenv install
pipenv shell 

# start a server
pipenv run start


optional
↓
# Create a user
python manage.py migrate

# Create a user
python manage.py createsuperuser --email admin@example.com --username admin


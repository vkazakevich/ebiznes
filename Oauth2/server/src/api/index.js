import { Router } from 'express'

import auth from '#api/auth'

const router = Router()

router.use('/', auth)

export default router
